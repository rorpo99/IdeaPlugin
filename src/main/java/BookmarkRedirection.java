import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileEditor.OpenFileDescriptor;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.CollectingContentIterator;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.intellij.openapi.ui.Messages.*;

public class BookmarkRedirection extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        String value = Messages.showInputDialog(
                "Choose your bookmark",
                "Bookmark Selection",
                getInformationIcon());

        int neededLine = BookmarkService.listOfBookmarksAndLines.get(value);

        var projects = ProjectManager.getInstance().getOpenProjects();
        VirtualFile vFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);

        new OpenFileDescriptor(projects[0], vFile, neededLine, 0).navigate(true);
    }
}
