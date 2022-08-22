package com.example.mycontact

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mycontact.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {
    private var _binding: FragmentAddContactBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

//        val menuHost: MenuHost = requireActivity()
//        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.findItem(R.id.action_save).isVisible = true
        menu.findItem(R.id.action_add).isVisible = false
        menu.findItem(R.id.action_profile).isVisible = true
        menu.findItem(R.id.action_settings).isVisible = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when(item.itemId){
            R.id.action_profile -> {
                val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                navController?.navigate(R.id.action_ContactFragment_to_ProfileFragment)
                return true
            }
            R.id.action_save -> {
                val name = binding.editTextTextPersonName.text.toString()
                val phone = binding.editTextPhone2.text.toString()
                MainActivity.contactList.add(Contact(name,phone))
                Toast.makeText(context, "Profile Saved", Toast.LENGTH_SHORT).show()
                val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
                navController?.navigateUp()
                return true
            }
            else -> false
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}