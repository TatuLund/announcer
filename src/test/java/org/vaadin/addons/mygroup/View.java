package org.vaadin.addons.mygroup;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout
        implements Announcer, AfterNavigationObserver {

    public View() {
        var button = new Button("Click me", e -> announce("Button clicked",
                AnnouncementMode.ASSERTIVE, 1000));
        add(new Paragraph("Inspect the page to see the announcement"), button);
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        announce("View navigated");
    }
}
