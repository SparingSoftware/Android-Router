### Sample project with Android Navigation / Routing with MVP architecture.

On branch [master](https://github.com/SparingSoftware/Android-Router "master") we have standard aproach with Fragment/Activity presenting other screens using Navigation Component, startActivity or FragmentTransaction.

On branch [router-simple](https://github.com/SparingSoftware/Android-Router/tree/simple-router "router-simple") there is an  implementation of simple Router which extract navigation operations from View. It is injected into Presenter which is able to navigate without calling view's methods.

**TODO**: Advanced Router:
- deeplinks
- saving state
- maybe with [Kompass](https://github.com/sellmair/kompass "Kompass") ? But how would it work with new Navigation Component?


---

### How it works

In standard approach Presenter (or view itself) will call method to navigate:
**In Presener / View:**
```
func loginClicked() {
  view?.showMain(loggedUser)
}
```
```
override fun showMain(user: User?) {
  val navController = findNavController()
  val bundle = Bundle()
  bundle.putParcelable("user", user)
  navController.navigate(R.id.showMain, bundle)
}
```

With Router we move navigation method to seperate module:
```
class LoginRouter(
  // ...

  override fun navigateTo(destination: Destination) {
    when(destination) {
      is Destination.Main -> {
        // ...
        navController?.navigate(R.id.showMain, bundle)
      }
    }
  }

  // ...
}
```
And a call is as simple as:
```
override fun loginClicked() {
  router?.navigateTo(Destination.Main(loggedUser))
}
```
