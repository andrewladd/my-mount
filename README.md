# my-mount

A Leiningen template for mount-based projects.

## Usage

Clone the repo.

Inside the repo: `lein jar`

Then: `lein install`

Then, when creating a new project: `lein new my-mount name-of-project`

When running this project, while inside its directory: 

```
lein repl

(user) => (dev)

... download dependencies and compile code ...

(dev) => (go)

... run mount services ...
```

### After changing some code:
```
(dev) => (reset)
```

### If the code doesn't compile:
```
(dev) => (refresh)
```

## License

Copyright © 2017 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
