package qantas.eqportal.owc.portlet.resource;

import java.util.ListResourceBundle;

public class DynamicOWCPortletBundle extends ListResourceBundle {
    public static final String PORTLET_INFO_TITLE = "javax.portlet.title";
    public static final String OK_LABEL = "oklabel";
    public static final String APPLY_LABEL = "applylabel";
    public static final String PORTLETTITLE = "javax.portlet.preference.name.portletTitle";
    public static final String PORTLET_INFO_SHORT_TITLE = "javax.portlet.short-title";
    private static final Object[][] sContents = {
        { PORTLET_INFO_TITLE, "DynamicOWCPortlet" }, { OK_LABEL, "OK" }, { APPLY_LABEL, "Apply" },
        { PORTLETTITLE, "Portlet Title" }, { PORTLET_INFO_SHORT_TITLE, "DynamicOWCPortlet" },
    };

    public Object[][] getContents() {
        return sContents;
    }
}
