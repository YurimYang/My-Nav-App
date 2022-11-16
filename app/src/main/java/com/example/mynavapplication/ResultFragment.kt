package com.example.mynavapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mynavapplication.databinding.FragmentResultBinding
import com.example.mynavapplication.viewmodel.MbtiViewModel


class ResultFragment : Fragment() {

    //val viewModel : MbtiViewModel by viewModels() //viewModels에서 viewModel로 위임을함
    val viewModel : MbtiViewModel by activityViewModels() // 여러 fragment가 viewModel을 공유함 (activiy에 붙어서 작동하는 viewModel로 만들어야함)


    var binding : FragmentResultBinding ? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.mbti.observe(viewLifecycleOwner){
            binding?.txtResult?.text = viewModel.mbti.value
        }
        //그 내용이 바뀌었을 경우, 또는 초기값을 갖고올경우
        //이 FRAGMENT의 LIFECYCLEOWNER이 갖고있을 만큼만 OBSERVE할 것!
        //observe(this)는 쓰면안됨 ! 잘못된 예제


        binding?.btnReexamine?.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_examineFragment)
        }

    }
}