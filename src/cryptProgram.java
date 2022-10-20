public class cryptProgram {
    public static void main(String[] args) {
        view theView = new view();
        model theModel = new model();
        controller theController = new controller(theView, theModel);
    }
}
