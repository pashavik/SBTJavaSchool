package plugin;

import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        if (s.startsWith("java") || s.equals("plugin.Plugin")) {
            return super.loadClass(s);
        }
        return findClass(s);
    }
}
