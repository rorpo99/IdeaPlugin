import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public interface BookmarkService {
    @NotNull HashMap<String, Integer> listOfBookmarksAndLines = new HashMap<>();
    @NotNull HashMap<String, VirtualFile> listOfFilesAndBookmarks = new HashMap<>();
}
