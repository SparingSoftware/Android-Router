package test.panowiep.android_router.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*
import test.panowiep.android_router.R
import java.lang.ref.WeakReference

class AboutActivity : AppCompatActivity(), IAboutView {


    private val presenter: IAboutPresenter by lazy {
        AboutPresenter(WeakReference(this))
    }

    //
    // Lifecycle
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        presenter.onViewCreated()
    }

    //
    // IAboutView
    //

    override fun setupViews() {
        exitButton.setOnClickListener {
            presenter.exitClicked()
        }
    }

    override fun exit() {
        finish()
    }

}
