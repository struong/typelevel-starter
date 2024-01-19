## Ticket-8

Extract out an interface to the stubbed database and use a real database.

There is a docker-compose file in the root of the project that will start a postgres database for you.

We use doobie as the pure functional JDBC layer: https://tpolecat.github.io/doobie/

Note: You will need to manually handle schema migrations.

To help you get started, use these imports:
```scala
import cats._
import cats.effect._
import cats.implicits._

import doobie._
import doobie.implicits._
import doobie.postgres.implicits._
import doobie.util._
```