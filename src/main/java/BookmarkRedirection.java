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

import java.beans.FeatureDescriptor;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static com.intellij.openapi.ui.Messages.*;

public class BookmarkRedirection extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        String[] keyList = BookmarkService.listOfBookmarksAndLines.keySet().toArray(new String[0]);
        int value = Messages.showDialog("Choose your bookmark", "Bookmark Selection", keyList, -1, getInformationIcon());
        if (value == -1) {
            return;
        }
        int neededLine = BookmarkService.listOfBookmarksAndLines.get(keyList[value]);
        VirtualFile file = BookmarkService.listOfFilesAndBookmarks.get(keyList[value]);
        var projects = ProjectManager.getInstance().getOpenProjects();
        new OpenFileDescriptor(projects[0], file, neededLine, 0).navigate(true);
    }
}
