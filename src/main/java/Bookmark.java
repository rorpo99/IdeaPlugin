import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;


public class Bookmark extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        int position = editor.getCaretModel().getLogicalPosition().line;
        //Messages.showMessageDialog(String.valueOf(position), "dhfjdhj", Messages.getQuestionIcon());
        String msg = Messages.showInputDialog("Input name of you bookmark", "Bookmark Name", Messages.getInformationIcon());
        BookmarkService.listOfBookmarksAndLines.put(msg, position);
    }
}
