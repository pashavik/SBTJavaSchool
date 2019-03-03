public class Main {
    public static void main(String[] args) {
        Person ivan=new Person(true, "Ivan");
        Person ann=new Person(false, "Ann");

        Person ivan2=new Person(true, "Ivan2");
        Person ann2=new Person(false, "Ann2");

        ivan.marry(ann);
        System.out.println("success: "+ivan.getName()+ " и "+ann.getName()+" married");

        ivan2.marry(ann2);
        System.out.println("success: "+ivan2.getName()+ " и "+ann2.getName()+" married");

        System.out.println();

        if(ivan.marry(ann)){
            System.out.println("old family registered once more");
        } else System.out.println("enable to register twice");

        System.out.println();

        ivan2.marry(ann);
        System.out.println("new family: "+ivan2.getName()+" и "+ann.getName());

        System.out.println();

        if(ivan.marry(ivan2)){
            System.out.println("success: "+ivan.getName()+ " и "+ivan2.getName()+" married");
        } else System.out.println("same gender");


        System.out.println();

        ann.divorce();
        System.out.println(ann.getName()+" divorced with "+ivan2.getName());

        System.out.println();

        if(ivan2.divorce()){
            System.out.println(ivan2.getName()+" divorced with "+ann.getName());
        }else System.out.println("divorce is already filed");
    }

}
