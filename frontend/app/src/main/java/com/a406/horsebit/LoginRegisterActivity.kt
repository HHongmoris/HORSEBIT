package com.a406.horsebit

import android.content.Intent
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.a406.horsebit.databinding.ActivityLoginRegisterBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding
    private val api = APIS.create();

    private val tokenShowList: ArrayList<TokenShow> = ArrayList()

    private var checkflag = arrayOf(false,false,false)
    private var flag = arrayOf(false,false,false)


//    private val binding by lazy {
//        ActivityLoginRegisterBinding.inflate(layoutInflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        tokenShowList.clear()
        api.tokenList(authorization = "Bearer ${1}").enqueue(object: Callback<ArrayList<Token>> {
            override fun onResponse(call: Call<ArrayList<Token>>, response: Response<ArrayList<Token>>) {
                if(response.code() == 200) {    // 200 Success
                    Log.d("로그", "토큰 조회: 200 Success")

                    val responseBody = response.body()

                    Log.d("dddd", responseBody.toString())

                    if(responseBody != null) {
                        for(token in responseBody) {
                            val tokenShow = TokenShow(1, token.name, token.code, token.currentPrice, token.priceTrend, token.volume, token.newFlag)
                            tokenShowList.add(tokenShow)
                        }
                    }
                }
                else if(response.code() == 400) {   // 400 Bad Request - Message에 누락 필드명 기입
                    Log.d("로그", "토큰 조회: 400 Bad Request")
                }
                else if(response.code() == 401) {   // 401 Unauthorized - 인증 토큰값 무효
                    Log.d("로그", "토큰 조회: 401 Unauthorized")
                }
                else if(response.code() == 404) {   // 404 Not Found
                    Log.d("로그", "토큰 조회: 404 Not Found")
                }
            }
            override fun onFailure(call: Call<ArrayList<Token>>, t: Throwable) {
                Log.d("로그", "토큰 조회: onFailure")
                Log.d("ddddd", t.toString())
            }
        })
        // tvLookingText1의 클릭 리스너를 먼저 설정합니다.
        binding.tvLookingText1.setOnClickListener {
            // LinearLayout의 visibility를 visible로 변경합니다.
            if (binding.llhRegisterGone1.visibility == View.VISIBLE) {
                binding.llhRegisterGone1.visibility = View.GONE
            } else {
                binding.llhRegisterGone1.visibility = View.VISIBLE
                Toast.makeText(getApplicationContext(), "모든 약관을 확인하세요!", Toast.LENGTH_LONG).show();
            }
        }



        binding.tvUnderAgree1.setOnClickListener {
            // LinearLayout의 visibility를 visible로 변경합니다.

            if (binding.llhRegisterGone1.visibility == View.VISIBLE) {
                binding.llhRegisterGone1.visibility = View.GONE
            }
            else {
                binding.llhRegisterGone1.visibility = View.VISIBLE
                Toast.makeText(getApplicationContext(), "모든 약관을 확인하세요!", Toast.LENGTH_LONG).show();
            }

        }


        // ScrollView의 스크롤 리스너를 설정합니다.
        binding.svGone1.setOnScrollChangeListener { _, _, scrollY1, _, _ ->
            val totalHeight = binding.svGone1.getChildAt(0).height - binding.svGone1.height

            if (scrollY1 >= totalHeight) {
                flag[0] = true
            }
            // 스크롤 위치가 맨 아래로 도달하면 이미지를 변경합니다.
            if (flag[0]) {
                // 이미 클릭 리스너가 설정되어 있다면, 이미지를 변경합니다.
                binding.tvLookingText1.setOnClickListener {
                    binding.ivGreyCheck1.setImageResource(R.drawable.ok_green)
                    checkflag[0] = true
                    checkflag[0] = !checkflag[0]
                    registerPossible ()
                    saveData() // 데이터 저장
                }
                binding.tvUnderAgree1.setOnClickListener {
                    binding.ivGreyCheck1.setImageResource(R.drawable.ok_green)
                    checkflag[0] = true
                    registerPossible ()
                    saveData() // 데이터 저장
                }
            }
        }

        binding.tvLookingText2.setOnClickListener {
            // LinearLayout의 visibility를 visible로 변경합니다.
            if (binding.llhRegisterGone2.visibility == View.VISIBLE) {
                binding.llhRegisterGone2.visibility = View.GONE
            } else {
                binding.llhRegisterGone2.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "모든 약관을 확인하세요!", Toast.LENGTH_LONG).show()
            }
        }

        binding.tvUnderAgree2.setOnClickListener {
            // LinearLayout의 visibility를 visible로 변경합니다.
            if (binding.llhRegisterGone2.visibility == View.VISIBLE) {
                binding.llhRegisterGone2.visibility = View.GONE
            } else {
                binding.llhRegisterGone2.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "모든 약관을 확인하세요!", Toast.LENGTH_LONG).show()
            }
        }

// ScrollView의 스크롤 리스너를 설정합니다.
        binding.svGone2.setOnScrollChangeListener { _, _, scrollY2, _, _ ->
            val totalHeight = binding.svGone2.getChildAt(0).height - binding.svGone2.height

            if (scrollY2 >=  totalHeight) {
                flag[1] = true
                     }
                if (flag[1]) {
                    binding.tvLookingText2.setOnClickListener {
                        binding.ivGreyCheck2.setImageResource(R.drawable.ok_green)
                        checkflag[1] = true
                        registerPossible ()
                        saveData() // 데이터 저장
                    }
                    binding.tvUnderAgree2.setOnClickListener {
                        binding.ivGreyCheck2.setImageResource(R.drawable.ok_green)
                        checkflag[1] = true
                        registerPossible ()
                        saveData() // 데이터 저장
                    }
            }
        }







        binding.tvLookingText4.setOnClickListener {
            if (binding.llhRegisterGone4.visibility == View.VISIBLE) {
                binding.llhRegisterGone4.visibility = View.GONE
            }
            else {
                binding.llhRegisterGone4.visibility = View.VISIBLE
            }

        }

        binding.tvUnderAgree4.setOnClickListener {
            if (binding.llhRegisterGone4.visibility == View.VISIBLE) {
                binding.llhRegisterGone4.visibility = View.GONE
            }
            else {
                binding.llhRegisterGone4.visibility = View.VISIBLE
                binding.ivGreyCheck4.setImageResource(R.drawable.ok_green)
            }

        }

        // ScrollView의 스크롤 리스너를 설정합니다.
        binding.svGone3.setOnScrollChangeListener { _, _, scrollY3, _, _ ->
            val totalHeight = binding.svGone3.getChildAt(0).height - binding.svGone3.height

            if (scrollY3 >= totalHeight) {
                flag[2] = true
            }
            // 스크롤 위치가 맨 아래로 도달하면 이미지를 변경합니다.
            if (flag[2]) {
                // 이미 클릭 리스너가 설정되어 있다면, 이미지를 변경합니다.
                binding.tvLookingText4.setOnClickListener {
                    binding.ivGreyCheck4.setImageResource(R.drawable.ok_green)
                    checkflag[2] = true
                    registerPossible ()
                    saveData() // 데이터 저장
                }
                binding.tvUnderAgree4.setOnClickListener {
                    binding.ivGreyCheck4.setImageResource(R.drawable.ok_green)
                    checkflag[2] = true
                    registerPossible ()
                    saveData() // 데이터 저장
                }
            }


        }



    }

    private fun loadData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)  // import androidx.preference.PreferenceManager 인지 확인
        val token = pref.getString("token", "")
        // binding.[데이터를 쓸 곳].setText(pref.getString("[키]", "[키가 없을 경우의 값]"))
    }

    private fun saveData() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val edit = pref.edit()

        // 토큰 정보를 저장
        val token = "your_token_here" // 실제 토큰 정보로 대체
        edit.putString("[키]", "[데이터]")


        // 닉네임 정보도 동일하게 저장할 수 있습니다.
        val nickname = "your_nickname_here" // 실제 닉네임 정보로 대체
        edit.putString("[키]", "[데이터]")


        edit.apply()    // 적용

    }

    private fun registerPossible() {
        if (checkflag[0] && checkflag[1]) {
            binding.vRegisterFinal.setBackgroundResource(R.drawable.rounded_shape_green_ractangle)
            binding.flRegisterFinal.setOnClickListener {
                val intent = Intent(this@LoginRegisterActivity, MainActivity::class.java)
                startActivity(intent)
                saveData() // 데이터 저장
            }
            if (checkflag[2]) {
                binding.ivCircleCheck.setBackgroundResource(R.drawable.rounded_shape_green_ractangle)
                binding.flRegisterFinal.setOnClickListener {
                    val intent = Intent(this@LoginRegisterActivity, MainActivity::class.java)
                    startActivity(intent)
                    saveData() // 데이터 저장
            }
        }
    }



}
}
