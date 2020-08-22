package ke.co.hello

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*
import java.util.regex.Matcher

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<Course>()
        var courses: listOf
                courses("6677888888888","Monicah Nyokabi","Python","5647","Best course")
                courses("6643568888","Stella Jerop","BootStrap","5453","Medium course")
                courses("6677548968","Nicole Lorna","PHp","5667","Worst course")
                courses("665467778888","Jann Wanjiru","Java","5677","Best course")
                courses("6677888888888","Cherryl Akinyi","Python","5547","Best course")
                courses("6677888888888","Hannah Cherriot","Python","5647","Best course")
                courses("6677888888888","Bastard Owino","5687","Best course")
                courses("667787778888","Hellen Evans","C++","5697","Best course")
                courses("6677888332211","Gitongo Mwonae","Enterprenuership","5327","Best course")
                courses("667788666688","Purity Nganga","Javascript","907","Best course")
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesAdapter(courseList)


        fetchCourses()
    }

    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getusers("Bearer " + accessToken)
        val enqueue: Any = coursesCall.enqueue(object : Callback<CoursesResponse> {
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Course>
                    var coursesAdapter = CoursesAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }

        })
    }
}


