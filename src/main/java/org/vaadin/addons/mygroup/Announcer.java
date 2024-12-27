package org.vaadin.addons.mygroup;

import com.vaadin.flow.component.dependency.JsModule;

import com.vaadin.flow.component.HasElement;

/**
 * The {@code Announcer} interface provides methods to announce messages to the
 * user. It supports different modes of announcements and allows specifying a
 * timeout for the announcement.
 * 
 * <p>
 * The interface uses JavaScript modules to perform the announcements and
 * extends the {@link HasElement} interface.
 * </p>
 * 
 * <h2>Usage</h2>
 * 
 * <pre>
 * {@code
 * Announcer announcer = ...;
 * announcer.announce("This is a polite announcement", AnnouncementMode.POLITE, 3000);
 * announcer.announce("This is an assertive announcement", AnnouncementMode.ASSERTIVE, 5000);
 * announcer.announce("This is a default polite announcement");
 * }
 * </pre>
 * 
 * <h2>Announcement Modes</h2>
 * <p>
 * The {@link AnnouncementMode} enum defines the modes of announcements:
 * </p>
 * <ul>
 * <li>{@link AnnouncementMode#POLITE}: Represents a polite announcement
 * mode.</li>
 * <li>{@link AnnouncementMode#ASSERTIVE}: Represents an assertive announcement
 * mode.</li>
 * </ul>
 * 
 * <h2>Methods</h2>
 * <ul>
 * <li>{@link #announce(String, AnnouncementMode, int)}: Announces a message
 * with a specified mode and timeout.</li>
 * <li>{@link #announce(String)}: Announces a message using the POLITE mode and
 * no timeout.</li>
 * </ul>
 */
@JsModule("./src/announcer.js")
public interface Announcer extends HasElement {

    /**
     * Enum representing the mode of an announcement. The mode can be either
     * "polite" or "assertive".
     * 
     * <ul>
     * <li>POLITE: Represents a polite announcement mode.</li>
     * <li>ASSERTIVE: Represents an assertive announcement mode.</li>
     * </ul>
     * 
     * Each mode is associated with a string value that can be retrieved using
     * the {@link #toString()} method.
     */
    public enum AnnouncementMode {
        POLITE("polite"), ASSERTIVE("assertive");

        private String mode;

        AnnouncementMode(String mode) {
            this.mode = mode;
        }

        @Override
        public String toString() {
            return mode;
        }
    }

    /**
     * Announces a message with a specified mode and timeout.
     *
     * @param announcement
     *            the message to be announced
     * @param mode
     *            the mode in which the announcement should be made
     * @param timeout
     *            the duration in milliseconds for which the announcement should
     *            be displayed
     */
    default void announce(String announcement, AnnouncementMode mode,
            int timeout) {
        getElement().executeJs("window.announce($0, $1, $2)", announcement,
                mode.toString(), timeout);
    }

    /**
     * Announces a message using with POLITE mode and no timeout.
     *
     * @param announcement
     *            the message to be announced
     */
    default void announce(String announcement) {
        getElement().executeJs("window.announce($0)", announcement);
    }
}
