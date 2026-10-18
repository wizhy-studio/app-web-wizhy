package in.wizhy.app.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

object ActionUtils {

    fun openWhatsApp(context: Context, phoneNumber: String = "919870706956", message: String = "Hi Wizhy Web Studio, I want to discuss a website project.") {
        try {
            val encodedMsg = Uri.encode(message)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=$encodedMsg")
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open WhatsApp. Please check if it's installed.", Toast.LENGTH_SHORT).show()
        }
    }

    fun makeCall(context: Context, phoneNumber: String = "+919870706956") {
        try {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not launch dialer.", Toast.LENGTH_SHORT).show()
        }
    }

    fun sendEmail(context: Context, email: String = "techwizhy@gmail.com", subject: String = "Website Inquiry - Wizhy Web Studio") {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, subject)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not launch email app.", Toast.LENGTH_SHORT).show()
        }
    }

    fun openWebsite(context: Context, url: String = "https://web.wizhy.in/") {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open browser.", Toast.LENGTH_SHORT).show()
        }
    }
}
