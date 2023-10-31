package tranhph26979.fpoly.bai6_rettrofit.dagger


import android.app.Application
import javax.inject.Inject

class ExerciseApplication : Application() {
    @Inject
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
       appComponent=DaggerAppComponent.create()
    }
}