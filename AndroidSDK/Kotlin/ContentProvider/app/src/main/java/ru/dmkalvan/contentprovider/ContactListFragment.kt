package ru.dmkalvan.contentprovider

import android.Manifest
import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import ru.dmkalvan.contentprovider.databinding.FragmentContactListBinding


const val REQUEST_CODE = 42

class ContactListFragment : Fragment() {

    private var _binding: FragmentContactListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentContactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                    getContacts()
                } else {
                    context?.let {
                        AlertDialog.Builder(it)
                            .setTitle(R.string.title_contact_permission)
                            .setMessage(R.string.reason_for_permission)
                            .setPositiveButton(R.string.positive){ _, _ ->
                                requestPermissions()
                            }
                            .setNegativeButton(R.string.negative) {dialog, _ -> dialog.dismiss()}
                            .create()
                            .show()
                    }

                }
            }
        }
    }

    private fun checkPermission() {
        context?.let {
            when{
                ContextCompat.checkSelfPermission(it, Manifest.permission.READ_CONTACTS) ==
                        PackageManager.PERMISSION_GRANTED -> {
                            getContacts()
                        }
                shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS) -> {
                    AlertDialog.Builder(it)
                        .setTitle(R.string.title_contact_permission)
                        .setMessage(R.string.reason_for_permission)
                        .setPositiveButton(R.string.positive){ _, _ ->
                            requestPermissions()
                        }
                        .setNegativeButton(R.string.negative) {dialog, _ -> dialog.dismiss()}
                        .create()
                        .show()
                }
                else -> {
                    requestPermissions()
                }
            }
        }
    }

    private fun getContacts() {
        context?.let {
            val contentResolver: ContentResolver = it.contentResolver

            val cursorWithContacts: Cursor? = contentResolver.query(
                ContactsContract.Contacts.CONTENT_URI,
                null,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"
            )

            cursorWithContacts?.let {
                cursor ->
                for (i in 0..cursor.count){
                    if (cursor.moveToPosition(i)){
                        val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                        addView(it, name)
                    }
                }
            }
            cursorWithContacts?.close()
        }
    }

    private fun addView(it: Context, name: String) {
        binding.contactContainer.addView(AppCompatTextView(it).apply {
            text = name
            textSize = resources.getDimension(R.dimen.contact_list_text_size)
        })
    }

    private fun requestPermissions() {
        requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CODE)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {

        fun newInstance() = ContactListFragment()
    }
}