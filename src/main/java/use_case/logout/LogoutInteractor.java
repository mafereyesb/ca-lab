package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        // 1) read who is logged in
        String username = userDataAccessObject.getCurrentUsername();
        // 2) clear the current user/session
        userDataAccessObject.setCurrentUsername(null);
        // 3) build output data with the username
        LogoutOutputData outputData = new LogoutOutputData(username);
        // 4) notify presenter
        logoutPresenter.prepareSuccessView(outputData);
    }
}

