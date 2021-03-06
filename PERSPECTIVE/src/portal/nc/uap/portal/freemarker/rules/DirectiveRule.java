package nc.uap.portal.freemarker.rules;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.Token;


public class DirectiveRule extends MultiLineRule {

	protected static final char[] START_SEQUENCES = {'<', '['};
	protected static Map END_SEQUENCES = new HashMap(START_SEQUENCES.length);
	protected char[] sequence;
	protected boolean nameOnly = false;
	
	static {
		END_SEQUENCES.put(Character.valueOf(START_SEQUENCES[0]), Character.valueOf('>'));
		END_SEQUENCES.put(Character.valueOf(START_SEQUENCES[1]), Character.valueOf(']'));
	}

	public DirectiveRule(String name, IToken token) {
		this(name, token, false);
	}

	public DirectiveRule(String name, IToken token, boolean nameOnly) {
		super("!", "!", token);
		this.sequence = name.toCharArray();
		this.nameOnly = nameOnly;
	}

	protected boolean sequenceDetected(
		ICharacterScanner scanner,
		int startChar,
		boolean eofAllowed) {
		for (int i= 0; i < sequence.length; i++) {
			int c= scanner.read();
			char cCheck = (char) c;
			if (c == ICharacterScanner.EOF && eofAllowed) {
				return true;
			} else if (c != sequence[i]) {
				// Non-matching character detected, rewind the scanner back to the start.
				// Do not unread the first character.
				scanner.unread();
				for (int j= i; j > 0; j--)
					scanner.unread();
				return false;
			}
		}

		return true;
	}

	protected boolean endSequenceDetected(ICharacterScanner scanner, int startChar) {
		char endChar = ((Character) END_SEQUENCES.get(Character.valueOf((char) startChar))).charValue();
		int c;
		char[][] delimiters= scanner.getLegalLineDelimiters();
		boolean previousWasEscapeCharacter = false;	
		Stack keyStack = new Stack();
		int charsRead = 0;
		while ((c= scanner.read()) != ICharacterScanner.EOF) {
			charsRead ++;
			char cCheck = (char) c;
			if (nameOnly) {
				if (c != endChar) {
					scanner.unread();
					return false;
				}
				else {
					return true;
				}
			}
			else if (c == startChar) {
				int cNext = scanner.read();
				if (cNext == ICharacterScanner.EOF) break;
				if (cNext == '#' || cNext == '@') {
					if (keyStack.size() == 0) {
						break;
					}
				}
				else {
					keyStack.push(new String(new char[]{(char) c}));
					scanner.unread();
				}
			}
			else if (c == '\"') {
				if (keyStack.size() > 0 && keyStack.peek().equals("\"")) {
					keyStack.pop();
				}
				else {
					keyStack.push("\"");
				}
			}
			else if (c == '(') {
				if (keyStack.size() > 0 && keyStack.peek().equals("\"")) {
					// string... don't add to stack
				}
				else {
					keyStack.push("(");
				}
			}
			else if (c == ')') {
				if (keyStack.size() > 0 && keyStack.peek().equals("\"")) {
					// string... don't add to stack
				}
				else if (keyStack.size() > 0 && keyStack.peek().equals("(")) {
					keyStack.pop();
				}
			}
			else if (c == fEscapeCharacter) {
				// Skip the escaped character.
				scanner.read();
				charsRead ++;
			}
			else if (c == endChar) {
				if (keyStack.size() == 0) {
					return true;
				}
				else if (keyStack.peek().equals(new String(new char[]{(char) startChar}))) {
					keyStack.pop();
				}
			}
			else if (fBreaksOnEOL) {
				// Check for end of line since it can be used to terminate the pattern.
				for (int i= 0; i < delimiters.length; i++) {
					if (c == delimiters[i][0] && sequenceDetected(scanner, delimiters[i], true)) {
						if (!fEscapeContinuesLine || !previousWasEscapeCharacter) {
							return true;
						}
					}
				}
			}
			previousWasEscapeCharacter = (c == fEscapeCharacter);
		}
		if (fBreaksOnEOF) return true;
		for (int i=0; i<charsRead; i++)
			scanner.unread();
		return false;
	}

	/**
	 * Evaluates this rules without considering any column constraints. Resumes
	 * detection, i.e. look sonly for the end sequence required by this rule if the
	 * <code>resume</code> flag is set.
	 *
	 * @param scanner the character scanner to be used
	 * @param resume <code>true</code> if detection should be resumed, <code>false</code> otherwise
	 * @return the token resulting from this evaluation
	 * @since 2.0
	 */
	protected IToken doEvaluate(ICharacterScanner scanner, boolean resume) {
		if (resume) {
			if (endSequenceDetected(scanner))
				return fToken;
		} else {
			int c= scanner.read();
			char cCheck = (char) c;
			if (c == START_SEQUENCES[0] || c == START_SEQUENCES[1]) {
				// check for the sequence identifier
				int c2 = scanner.read();
				if (c2 == getIdentifierChar()) {
					if (sequenceDetected(scanner, c, false)) {
						if (endSequenceDetected(scanner, c))
							return fToken;
					}
				}
				scanner.unread();
			}
		}
		scanner.unread();
		return Token.UNDEFINED;
	}

	protected char getIdentifierChar() {
		return '#';
	}
}