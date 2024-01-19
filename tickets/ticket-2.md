## Ticket-2

Using `pureconfig` inject in the HTTP port and host from the `application.conf` file.

Optional: You can load the values in as String and Ints but to keep the types refined we can use 
provided types from `ip4s`:

```scala
import com.comcast.ip4s.Host
import com.comcast.ip4s.Port
```

#### Hints

You can load the config using:

```scala
    ConfigSource.default.loadF[IO, EmberConfig].flatMap { config =>
      val appResource = for {
        algebras <- Algebras[IO] 
        ...
```