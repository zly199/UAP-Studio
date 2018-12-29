package nc.uap.portal.events;

import nc.uap.portal.core.PortalBaseRectangleFigure;
import nc.uap.portal.core.PortalElementObjWithGraph;
import nc.uap.portal.lang.M_portal;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * �¼�����ͼ��
 * 
 * @author dingrf
 */
public class EventsEleObjFigure extends PortalBaseRectangleFigure{

	/**
	 * ����ͼ����ɫ
	 */
	private static Color bgColor = new Color(null, 214, 101, 160);
	
	public EventsEleObjFigure(PortalElementObjWithGraph ele){
		super(ele);
		setTypeLabText(M_portal.EventsEleObjFigure_0);
		setBackgroundColor(bgColor);
		EventsElementObj portletApp = (EventsElementObj) ele;
		Point point = portletApp.getLocation();
		int x, y;
		if(point != null){
			x = point.x;
			y = point.y;
		}else{
			x = 100;
			y = 100;
		}
		setBounds(new Rectangle(x, y, 150, 150));
		
	}
	
	protected String getTypeText() {
		return M_portal.EventsEleObjFigure_0;
	}
}
	