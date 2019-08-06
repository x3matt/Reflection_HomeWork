
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Informant {

    private Class clazz;

    private static String getType(Class clazz){
        String type = clazz.isArray()?clazz.getComponentType().getSimpleName():clazz.getSimpleName();
        if(clazz.isArray()){
            type+="[]";
        }
        return type;
    }

    private static String getParameters(Class[] params){
        String param = "";
        for(int i=0,size = params.length;i<size;i++){
            if(i > 0){
                param+=",";
            }
            param+=getType(params[i])+ " param";
        }
        return param;
    }

    private static String getModifiers(int mod){
        String modifiers = "";
        if(Modifier.isPublic(mod)){
            modifiers += "public ";
        }
        if(Modifier.isPrivate(mod)){
            modifiers += "private ";
        }
        if(Modifier.isProtected(mod)){
            modifiers += "protected ";
        }
        if(Modifier.isFinal(mod)){
            modifiers += "final ";
        }
        if(Modifier.isNative(mod)){
            modifiers +="native ";
        }
        if(Modifier.isStrict(mod)){
            modifiers +="strict ";
        }
        if(Modifier.isSynchronized(mod)){
            modifiers +="synchronized ";
        }
        if(Modifier.isTransient(mod)){
            modifiers +="transient ";
        }
        if(Modifier.isVolatile(mod)){
            modifiers +="volatile ";
        }
        if(Modifier.isAbstract(mod)){
            modifiers += "abstract ";
        }
        if(Modifier.isStatic(mod)){
            modifiers += "static ";
        }
        if(Modifier.isInterface(mod)){
            modifiers += "interface ";
        }
        return modifiers;
    }

    private static void getAnnotations(Annotation[] annotations){
        for (int i = 0,size = annotations.length; i<size;i++){
            System.out.println("@"+annotations[i].annotationType().getSimpleName());
        }
    }

    public Informant(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    @Override
    public String toString() {
        return "Informant{" +
                "clazz=" + clazz +
                '}';
    }

    public void getMethods(){
        Method[] methods = clazz.getDeclaredMethods();
        for(int i = 0, size = methods.length; i < size;i++){
            Annotation[] annotations = methods[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(methods[i].getModifiers())+getType(methods[i].getReturnType())+" "+methods[i].getName()+"("+getParameters(methods[i].getParameterTypes())+");");
        }
        System.out.println();
    }

    public static void getMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        for(int i = 0, size = methods.length; i < size;i++){
            Annotation[] annotations = methods[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(methods[i].getModifiers())+getType(methods[i].getReturnType())+" "+methods[i].getName()+"("+getParameters(methods[i].getParameterTypes())+");");
        }
        System.out.println();
    }

    public void getConstructors(){
        Constructor[] constructors = clazz.getConstructors();
        for (int i = 0, size = constructors.length; i < size;i++){
            Annotation[] annotations = constructors[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(constructors[i].getModifiers())+constructors[i].getName()+"("+getParameters(constructors[i].getParameterTypes())+");");
        }
        System.out.println();
    }

    public static void getConstructors(Class clazz){
        Constructor[] constructors = clazz.getConstructors();
        for (int i = 0, size = constructors.length; i < size;i++){
            Annotation[] annotations = constructors[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(constructors[i].getModifiers())+constructors[i].getName()+"("+getParameters(constructors[i].getParameterTypes())+");");
        }
        System.out.println();
    }

    public void getFields(){
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0, size = fields.length; i < size;i++){
            Annotation[] annotations = fields[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(fields[i].getModifiers())+getType(fields[i].getType())+" "+fields[i].getName()+";");
        }
        System.out.println();
    }

    public static void getFields(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0, size = fields.length; i < size;i++){
            Annotation[] annotations = fields[i].getDeclaredAnnotations();
            getAnnotations(annotations);
            System.out.println(getModifiers(fields[i].getModifiers())+getType(fields[i].getType())+" "+fields[i].getName()+";");
        }
        System.out.println();
    }

    public void getAllInfoAboutClass(){
        getFields();
        getConstructors();
        getMethods();
    }

    public static void getAllInfoAboutClass(Class clazz){
        getFields(clazz);
        getConstructors(clazz);
        getMethods(clazz);
    }

}