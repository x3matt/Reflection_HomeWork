public class Main {
    public static void main(String[] args) {
        Informant informant = new Informant(TestClass.class);
//        informant.getFields();
//        informant.getConstructors();
//        informant.getMethods();
//        informant.getAllInfoAboutClass();
//           Informant.getFields(TestClass.class);
//           Informant.getConstructors(TestClass.class);
//           Informant.getMethods(TestClass.class);
//           Informant.getAllInfoAboutClass(TestClass.class);
        informant.getConstructors();
    }
}

