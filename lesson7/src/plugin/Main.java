package plugin;

public class Main {
    public static void main(String[] args) {
        PluginManager manager=new PluginManager("file://C:/Users/pashp/IdeaProjects/SBTJavaSchool/lesson7/src/plugin/plugins");
        Plugin plagin1=manager.load("PluginImpl", "plugin.plugins.plugin1");
        plagin1.doUsefull();
        Plugin plagin2=manager.load("AnotherPluginImpl", "plugin.plugins.plugin2");
        plagin2.doUsefull();

    }
}
