package internal;

public enum Toggles {
    HEADLESS(Boolean.parseBoolean(System.getProperty("browser.headless", "false")));

    private final Boolean active;

    Toggles(Boolean active) {
        this.active = active;
    }

    public boolean isOn() {
        return active;
    }

    public boolean isOff() {
        return !active;
    }
}