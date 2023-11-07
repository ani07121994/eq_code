package qantas.eqportal.owc.portlet;

import java.io.IOException;

import java.util.StringTokenizer;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;

import qantas.eqportal.owc.portlet.resource.DynamicOWCPortletBundle;

public class DynamicOWCPortlet extends GenericPortlet {
    protected String getTitle(RenderRequest request) {
        // Get the customized title. This defaults to the declared title.
        PortletPreferences prefs = request.getPreferences();
        return prefs.getValue(PORTLETTITLE_KEY, super.getTitle(request));
    }

    protected void doDispatch(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        // Do nothing if window state is minimized.
        WindowState state = request.getWindowState();
        if (state.equals(WindowState.MINIMIZED)) {
            super.doDispatch(request, response);
            return;
        }

        // Get the content type for the response.
        String contentType = request.getResponseContentType();

        // Get the requested portlet mode.
        PortletMode mode = request.getPortletMode();

        // Reference a request dispatcher for dispatching to web resources
        PortletContext context = getPortletContext();
        PortletRequestDispatcher rd = null;

        // Dispatch based on content type and portlet mode.
        if (contentType.equals("text/html")) {
            if (mode.equals(PortletMode.VIEW)) {
                rd = context.getRequestDispatcher("/Dynamic_OWC_Portlet/html/view.jsp");
            } else if (mode.equals(PortletMode.EDIT)) {
                rd = context.getRequestDispatcher("/Dynamic_OWC_Portlet/html/edit.jsp");
            } else {
                super.doDispatch(request, response);
            }
        } else {
            super.doDispatch(request, response);
        }
        if (rd != null) {
            rd.include(request, response);
        } else {
            super.doDispatch(request, response);
        }
    }
    public static final String APPLY_ACTION = "apply_action";
    public static final String OK_ACTION = "ok_action";
    public static final String PORTLETTITLE_KEY = "portletTitle";

    private String[] buildValueArray(String values) {
        if (values.indexOf(',') < 0) {
            return new String[] { values };
        }
        StringTokenizer st = new StringTokenizer(values, ",");
        String[] valueArray = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            valueArray[i] = st.nextToken().trim();
            i++;
        }
        return valueArray;
    }

    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        // Determine which action.
        String okAction = request.getParameter(OK_ACTION);
        String applyAction = request.getParameter(APPLY_ACTION);

        if (okAction != null || applyAction != null) {
            // Save the preferences.
            PortletPreferences prefs = request.getPreferences();
            String param = request.getParameter(PORTLETTITLE_KEY);
            prefs.setValues(PORTLETTITLE_KEY, buildValueArray(param));
            prefs.store();
            if (okAction != null) {
                response.setPortletMode(PortletMode.VIEW);
                response.setWindowState(WindowState.NORMAL);
            }
        }
    }
}
