package ke.co.hello

import com.google.gson.annotations.SerializedName

data class logInREsponse(
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student
)