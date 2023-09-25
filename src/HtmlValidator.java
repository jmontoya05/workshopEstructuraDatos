import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

        Stack<HtmlTag> stackHtmlElememts = new Stack<>();

        while (!tags.isEmpty()) {

            if (tags.peek().isSelfClosing()) {
                tags.remove();
            } else if (!tags.peek().isOpenTag()) {
                if (stackHtmlElememts.empty()) {
                    return null;
                }

                if (stackHtmlElememts.peek().matches(tags.peek())) {
                    stackHtmlElememts.pop();
                    tags.remove();
                } else {
                    return stackHtmlElememts;
                }
            } else {
                stackHtmlElememts.push(tags.remove());
            }
        }

        return stackHtmlElememts;
    }
}

