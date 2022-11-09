package com.example.mynavapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mynavapplication.databinding.FragmentEntryBinding



class EntryFragment : Fragment() {
    var binding: FragmentEntryBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEntryBinding.inflate(inflater)

        // Inflate the layout for this fragment
        return binding?.root
    }

    //view가 모두 binding되고 나서 -! -> 버튼 눌렀을 때 setting해주기
    //위 함수에다가 써도 동작은 함. 그러나 findNavController는 onViewCreated가 불린 다음에 생성되기 때문에 아래에 놓는게 더 안점함
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAbout?.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_aboutFragment)
        }
        binding?.btnExamine?.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_examineFragment)
        }
        binding?.btnSettings?.setOnClickListener{
            findNavController().navigate(R.id.action_entryFragment_to_settingsFragment)
        }
    }

    //메모리가 깨지지 않기위해
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}