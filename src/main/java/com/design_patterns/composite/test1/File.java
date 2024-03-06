package com.design_patterns.composite.test1;

import com.design_patterns.composite.test1.FileSystemNode;

public class File extends FileSystemNode {
    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(super.getPath());
        if (!file.exists()) return 0;
        return file.length();
    }
}
