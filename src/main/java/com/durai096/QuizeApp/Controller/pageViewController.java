package com.durai096.QuizeApp.Controller;

import com.durai096.QuizeApp.Service.pageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viewer-count")
public class pageViewController {
    @Autowired
    pageView pageViewService;
    @GetMapping("/count")
    public int getViewerCount() {
        return pageViewService.getViewerCount();
    }

    @PostMapping("/increment")
    public void incrementViewerCount() {
        pageViewService.incrementViewerCount();
    }
}
