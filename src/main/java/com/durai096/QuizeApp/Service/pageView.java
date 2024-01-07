package com.durai096.QuizeApp.Service;

import org.springframework.stereotype.Service;

@Service
public class pageView {
    private int viewerCount = 0;

    public int getViewerCount() {
        return viewerCount;
    }

    public void incrementViewerCount() {
        viewerCount++;
    }
}
