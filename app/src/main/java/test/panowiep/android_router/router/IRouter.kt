package test.panowiep.android_router.router

import test.panowiep.android_router.model.User


//

sealed class Destination {

    data class Main(val user: User?): Destination()
    data class Profile(val user: User?): Destination()
    class About: Destination()
    class Login: Destination()

}

//



//


interface IRouter {

    fun navigateTo(destination: Destination)
    fun backTo(destination: Destination)
    fun back()

}