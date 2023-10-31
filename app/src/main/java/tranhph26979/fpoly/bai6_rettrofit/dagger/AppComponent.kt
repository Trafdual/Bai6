package tranhph26979.fpoly.bai6_rettrofit.dagger

import dagger.Component
import tranhph26979.fpoly.bai6_rettrofit.MainActivity
import javax.inject.Inject

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}