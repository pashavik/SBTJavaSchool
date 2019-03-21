package plugin.plugins.plugin2;

import plugin.Plugin;

public class AnotherPluginImpl implements Plugin {

    @Override
    public void doUsefull() {
        System.out.println("Plugin "+getClass().getName());
    }
}
