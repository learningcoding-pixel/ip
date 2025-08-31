public class DukeException extends Exception {

    // Constructor for the exception
    public DukeException(String message) {
        super(message);
    }

    /**
     * Static method to check for empty input.
     * Throws DukeException if input is empty.
     */
    public static void checkEmptyInput(String input) throws DukeException {
        if (input == null || input.trim().isEmpty()) {
            throw new DukeException("The input cannot be empty!");
        }
    }
}
