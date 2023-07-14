package com.yonakipro.caffeapp5.ui

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yonakipro.caffeapp5.R
import com.yonakipro.caffeapp5.application.PaymentApp
import com.yonakipro.caffeapp5.databinding.FragmentSecondBinding
import com.yonakipro.caffeapp5.payment.Payment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!
    private lateinit var applicationContext: Context
    private val paymentViewModel: PaymentViewModel by viewModels {
        PaymentViewModelFactory((applicationContext as PaymentApp).repository)
    }
    private val args: SecondFragmentArgs by navArgs()
    private  var payment: Payment? = null
    private lateinit var mMap: GoogleMap
    private var currentLatLang: LatLng? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    override fun onAttach(context: Context) {
        super.onAttach(context)
        applicationContext = requireContext().applicationContext
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        payment = args.payment
        if (payment != null){
            binding.deleteButton.visibility = View.VISIBLE
            binding.saveButton.text = "simpan"
            binding.nameOrderEditText.setText(payment?.nameOrder)
            binding.OrderEditText.setText(payment?.order)
            binding.addresEditText.setText(payment?.address)
            binding.chargeEditText.setText(payment?.charge)


        }

        //binding google map
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        chechkPermision()

        val nameOrder = binding.nameOrderEditText.text
        val order = binding.OrderEditText.text
        val address = binding.addresEditText.text
        val charge = binding.chargeEditText.text


        binding.saveButton.setOnClickListener {
            if (nameOrder.isEmpty()){
                Toast.makeText(context, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (order.isEmpty()) {
                Toast.makeText(context, "order tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (address.isEmpty()) {
                Toast.makeText(context, "Alamat tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else if (charge.isEmpty()) {
                Toast.makeText(context, "Total Bayar tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }else{
                if (payment == null){
                    val payment =Payment(0, nameOrder.toString(), order.toString() , address.toString(),charge.toString(), currentLatLang?.latitude, currentLatLang?.longitude )
                    paymentViewModel.insert(payment)
                }else{
                    val payment =Payment(payment?.id!!, nameOrder.toString(), order.toString() , address.toString(),charge.toString(),currentLatLang?.latitude, currentLatLang?.longitude )
                    paymentViewModel.update(payment)
                }

                findNavController().popBackStack()
            }

        }
        binding.deleteButton.setOnClickListener {
            payment?.let {paymentViewModel.delete(it) }
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //implement drag marker

        val uiSetting = mMap.uiSettings
        uiSetting.isZoomControlsEnabled = true
        mMap.setOnMarkerDragListener(this)
    }

    override fun onMarkerDrag(p0: Marker) {
    }

    override fun onMarkerDragEnd(marker: Marker) {
        val newPosition = marker.position
        currentLatLang = LatLng(newPosition.latitude, newPosition.longitude)
        Toast.makeText(context, currentLatLang.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onMarkerDragStart(p0: Marker) {
    }

    private fun chechkPermision(){
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(applicationContext)
        if (ContextCompat.checkSelfPermission(
            applicationContext,
            android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ){
            getCurrentLocation()
        }else{
            Toast.makeText(applicationContext, "Akses Lokasi di Tolak", Toast.LENGTH_SHORT).show()
        }
    }
    private fun getCurrentLocation(){
        //mengecekjika perission tidka di setujui maka akan berhenti di kondisi if
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ){
            return
        }
        //untuk test current location coba run di device atau build apk nya terus di install di hp masing-masing
        fusedLocationClient.lastLocation
            .addOnSuccessListener {location ->
                if (location != null){
                    var latLang = LatLng(location.latitude, location.longitude)
                    currentLatLang = latLang
                    var title = "Marker"
                    if (payment != null){
                        title = payment?.nameOrder.toString()
                        val newCurrentLocation = LatLng(payment?.latitude!!, payment?.longitude!!)
                        latLang = newCurrentLocation
                    }
                    val markerOption = MarkerOptions()
                        .position(latLang)
                        .title(title)
                        .draggable(true)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_meal_34))
                    mMap.addMarker(markerOption)
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang,15f))
                }
            }

    }
}