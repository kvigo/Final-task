package command.impl.page;

import command.Command;
import controller.Page;
import controller.SessionRequestContent;
import resource.ConfigurationManager;

public class AddRequestPageCommand implements Command {
    private static final String ERROR_REQUEST = "errorRequest";
    private static final String REQUEST_PAGE = ConfigurationManager.getProperty("page.request");
    private static final String REQUEST_PAGE_COMMAND = ConfigurationManager.getProperty("command.add_request_page");
    private static final String LOCALE_COMMAND = "localeCommand";

    @Override
    public Page execute(SessionRequestContent content) {
        String registrationError = content.getRequestParameter(ERROR_REQUEST);
        content.setRequestAttribute(ERROR_REQUEST, registrationError);
        content.setRequestAttribute(LOCALE_COMMAND, REQUEST_PAGE_COMMAND);
        return new Page(REQUEST_PAGE);
    }
}
