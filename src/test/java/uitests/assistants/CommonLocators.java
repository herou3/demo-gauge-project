package uitests.assistants;

public class CommonLocators {
    public static final String DIV_ATTRIBUTE_ERROR = "error-message-container error";
    public static final String INPUT_CLASS_ERROR = "input_error form_input error";
    public static final String DIV_INVALID_XPATH = ".//descendant-or-self::*[@class='" + DIV_ATTRIBUTE_ERROR + "']";
    public static final String QUANTITY_INVALID_ELEMENTS_XPATH = ".//descendant-or-self::input[@class='" + INPUT_CLASS_ERROR + "']";
}