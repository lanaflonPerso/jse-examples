### ServiceLoader

A _service_ is a well-known set of interfaces and (usually abstract) classes. A _service provider_ is a specific implementation of a service. The classes in a provider typically implement the interfaces and subclass the classes defined in the service itself. Service providers can be installed in an implementation of the Java platform in the form of extensions, that is, jar files placed into any of the usual extension directories. Providers can also be made available by adding them to the application's class path or by some other platform-specific means.

For the purpose of loading, a service is represented by a single type, that is, a single interface or abstract class. (A concrete class can be used, but this is not recommended.) A provider of a given service contains one or more concrete classes that extend this _service type_ with data and code specific to the provider. The _provider class_ is typically not the entire provider itself but rather a proxy which contains enough information to decide whether the provider is able to satisfy a particular request together with code that can create the actual provider on demand. The details of provider classes tend to be highly service-specific; no single class or interface could possibly unify them, so no such type is defined here. The only requirement enforced by this facility is that provider classes must have a zero-argument constructor so that they can be instantiated during loading.

[A service provider is identified by placing a _provider-configuration file_ in the resource directory 

META-INF/services. The file's name is the fully-qualified ]()[binary name](https://docs.oracle.com/javase/7/docs/api/java/lang/ClassLoader.html#name) of the service's type. The file contains a list of fully-qualified binary names of concrete provider classes, one per line. Space and tab characters surrounding each name, as well as blank lines, are ignored. The comment character is 

'#' (

'\u0023', NUMBER SIGN); on each line all characters following the first comment character are ignored. The file must be encoded in UTF-8.

If a particular concrete provider class is named in more than one configuration file, or is named in the same configuration file more than once, then the duplicates are ignored. The configuration file naming a particular provider need not be in the same jar file or other distribution unit as the provider itself. The provider must be accessible from the same class loader that was initially queried to locate the configuration file; note that this is not necessarily the class loader from which the file was actually loaded.

Providers are located and instantiated lazily, that is, on demand. A service loader maintains a cache of the providers that have been loaded so far. Each invocation of the [

iterator](https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html#iterator()) method returns an iterator that first yields all of the elements of the cache, in instantiation order, and then lazily locates and instantiates any remaining providers, adding each one to the cache in turn. The cache can be cleared via the [

reload](https://docs.oracle.com/javase/7/docs/api/java/util/ServiceLoader.html#reload()) method.

Service loaders always execute in the security context of the caller. Trusted system code should typically invoke the methods in this class, and the methods of the iterators which they return, from within a privileged security context.

Instances of this class are not safe for use by multiple concurrent threads.

Unless otherwise specified, passing a 

null argument to any method in this class will cause a [

NullPointerException](https://docs.oracle.com/javase/7/docs/api/java/lang/NullPointerException.html) to be thrown.