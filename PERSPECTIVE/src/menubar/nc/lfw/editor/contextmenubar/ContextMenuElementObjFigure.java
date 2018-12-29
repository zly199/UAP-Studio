package nc.lfw.editor.contextmenubar;

import java.util.Iterator;
import java.util.List;

import nc.lfw.editor.common.LFWBaseEditor;
import nc.lfw.editor.common.LFWBaseRectangleFigure;
import nc.lfw.editor.common.LfwElementObjWithGraph;
import nc.lfw.editor.menubar.MenuItemLabel;
import nc.lfw.editor.menubar.MenubarConnector;
import nc.lfw.editor.menubar.ele.MenuItemObj;
import nc.uap.lfw.core.comp.ContextMenuComp;
import nc.uap.lfw.core.comp.MenuItem;
import nc.uap.lfw.editor.common.tools.LFWAMCPersTool;
import nc.uap.lfw.lang.M_menubar;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * �Ҽ��˵�Figure
 * @author zhangxya
 *
 */
public class ContextMenuElementObjFigure extends LFWBaseRectangleFigure {

	private ContextMenuElementObj menubarObj;

	// Ĭ�ϴ�С
	private Dimension dimen;
	// �ܸ߶�
	private int height = 0;

	private static Color bgColor = new Color(null, 109, 115, 203);

	public ContextMenuElementObjFigure(LfwElementObjWithGraph ele) {
		super(ele);
		menubarObj = (ContextMenuElementObj) ele;
		setTypeLabText(M_menubar.ContextMenuElementObjFigure_0); //$NON-NLS-1$
		setBackgroundColor(bgColor);
		menubarObj.setFigure(this);
		if(menubarObj.getMenubar() != null)
			setTitleText(menubarObj.getMenubar().getId(), menubarObj.getMenubar().getId());
		addItems();
		markError(menubarObj.validate());
		// ���ô�С��λ��
		Point point = menubarObj.getLocation();
		dimen = menubarObj.getSize();
		this.height += 3 * LINE_HEIGHT;
		setBounds(new Rectangle(point.x, point.y, dimen.width,
				dimen.height < this.height ? this.height : dimen.height));

	}

	/**
	 * ��ʾ��������
	 */
	private void addItems() {
		ContextMenuComp menubar = menubarObj.getMenubar();
		if(menubar == null)
			return;
		List<MenuItem> itemList = menubar.getItemList();
		if (itemList != null) {
			Iterator<MenuItem> it = itemList.iterator();
			while (it.hasNext()) {
				MenuItem item = it.next();
				MenuItemLabel label = new MenuItemLabel(item);
				addToContent(label);
				this.height += LINE_HEIGHT;
				addItemLabelListener(label);
			}
		}
	}

	/**
	 * ��������Label���¼�
	 * 
	 * @param label
	 */
	private void addItemLabelListener(MenuItemLabel label) {
		label.addMouseListener(new MouseListener.Stub() {
			public void mouseDoubleClicked(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {
				MenuItemLabel currentLabel = (MenuItemLabel) e.getSource();
				// ȡ��������������ѡ��״̬
				LFWBaseEditor.getActiveEditor().getGraph().unSelectAllLabels();
				// ѡ�и�����
				selectLabel(currentLabel);

				// ��ʾ����
				MenuItem currentItem = (MenuItem) ((MenuItemLabel) currentLabel).getEditableObj();
				menubarObj.setCurrentItem(currentItem);
				
				// ������ʾ��������
				reloadPropertySheet(menubarObj);
				//�°���ʾ�¼�
				LFWBaseEditor.getActiveEditor().getViewPage().setWebElement(currentItem);
				LFWBaseEditor.getActiveEditor().getViewPage().addEventPropertiesView(currentItem.getEventConfs(), LFWAMCPersTool.getCurrentWidget().getControllerClazz());
				
				// ������ʾListener����
				if(ContextMenuEditor.getActiveMenubarEditor() != null){
					((ContextMenuGrahp)ContextMenuEditor.getActiveMenubarEditor().getGraph())
							.reloadListenerFigure((MenuItem)currentLabel.getEditableObj());
				}
			}
		});
	}

	/**
	 * ��������
	 * 
	 * @param signal
	 */
	public void addItem(MenuItem menuItem) {
		ContextMenuComp menubar = ContextMenuEditor.getActiveMenubarEditor().getMenubarTemp();//getActiveMenubarEditor().getMenubarTemp();
		int index = 0;
		if (null != menubar.getItemList())
			index = menubar.getItemList().size();
		menubar.addMenuItem(menuItem);
		MenuItemObj menuItemObj = new MenuItemObj();
		menuItemObj.setMenuItem(menuItem);
		menuItemObj.setId(menuItem.getId());
		menubarObj.addChild(menuItemObj);
		MenuItemLabel label = new MenuItemLabel(menuItem);
		addToContent(label, index);
		addItemLabelListener(label);
		this.height += LINE_HEIGHT;
		resizeHeight();
	}

	/**
	 * ɾ������
	 * 
	 * @param label
	 */
	public void deleteItem(MenuItemLabel label) {
		MenuItem item = (MenuItem) label.getEditableObj();
		ContextMenuComp menubar = ContextMenuEditor.getActiveMenubarEditor().getMenubarTemp();
		if (menubar.getItemList().contains(item)) {
			menubar.getItemList().remove(item);
			// ɾ���������
			ContextMenuEditor editor = ContextMenuEditor.getActiveMenubarEditor();
			MenubarConnector connector = editor.getConnector(item.getId());
			if (null != connector) {
				editor.removeConnector(item.getId());
				connector.disConnect();
			}
		}
		
		getContentFigure().remove(label);
		this.height -= LINE_HEIGHT;
		resizeHeight();
	}
	
	/**
	 * ˢ��ͼ��
	 */
	public void refresh() {
		IFigure title = (IFigure) getTitleFigure().getChildren().get(1);
		getTitleFigure().remove(title);
		setTitleText(menubarObj.getMenubar().getId(), menubarObj.getMenubar().getId());
		refreshItems();
	}
	
	/**
	 * ˢ�������������ʾ
	 */
	public void refreshItems() {
		// �Ƴ�ȫ��ԭ����
		while (getContentFigure().getChildren().size() > 0) {
			Object child = getContentFigure().getChildren().get(0);
			if (child instanceof MenuItemLabel) {
				getContentFigure().remove((MenuItemLabel) child);
				this.height -= LINE_HEIGHT;
			}
		}
		// ��ʾ��������
		addItems();
	}
	

//	private void removeCommands(MenuItem item) {
//		PageMeta pagemeta = LFWPersTool.getCurrentPageMeta();
//		Map<String, JsListenerConf> listenerMap = item.getListenerMap();
//		for (String listenerKey : listenerMap.keySet()) {
//			Map<String, EventHandlerConf> eventMap = listenerMap.get(listenerKey).getEventHandlerMap();
//			for (String eventKey : eventMap.keySet()) {
//				if (eventMap.get(eventKey) instanceof RefEventHandlerConf) {
//					String refId = ((RefEventHandlerConf)eventMap.get(eventKey)).getRefId();
//					pagemeta.removeCommand(refId);
//				}
//			}
//		}
//	}

	/**
	 * �������ø߶�
	 */
	private void resizeHeight() {
		setSize(dimen.width, dimen.height < this.height ? this.height
				: dimen.height);
	}

	
	protected String getTypeText() {
		return null;
	}

}