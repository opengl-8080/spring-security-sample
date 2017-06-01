package sample.servlet;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class HeaderInjectionRequestParameter {
    private static final Pattern CR_OR_LF = Pattern.compile("\\r|\\n");

    private final String rawHeaderName;
    private final String rawHeaderValue;
    private final boolean removeLineSeparator;

    public HeaderInjectionRequestParameter(HttpServletRequest req) {
        this.rawHeaderName = req.getParameter("headerName");
        this.rawHeaderValue = req.getParameter("headerValue");
        this.removeLineSeparator = "true".equals(req.getParameter("removeLineSeparator"));
    }

    public String getHeaderName() {
        return this.removeLineSeparatorIfEnable(this.rawHeaderName);
    }

    public String getHeaderValue() {
        return this.removeLineSeparatorIfEnable(this.rawHeaderValue);
    }
    
    private String removeLineSeparatorIfEnable(String rawValue) {
        return this.removeLineSeparator ? CR_OR_LF.matcher(rawValue).replaceAll("") : rawValue;
    }
}
