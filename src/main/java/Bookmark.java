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
        String msg = Messages.showInputDialog("Input name of you bookmark", "Bookmark Name", Messages.getInformationIcon());
        if (msg == null || msg.isEmpty()) {
            return;
        }
        BookmarkService.listOfBookmarksAndLines.put(msg, position);
        BookmarkService.listOfFilesAndBookmarks.put(msg, e.getData(PlatformDataKeys.VIRTUAL_FILE));
    }
}
