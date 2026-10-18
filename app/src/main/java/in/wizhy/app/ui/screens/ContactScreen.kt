package in.wizhy.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import in.wizhy.app.ui.components.ActionUtils
import in.wizhy.app.ui.theme.WizhyCream
import in.wizhy.app.ui.theme.WizhyOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen() {
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var serviceNeeded by remember { mutableStateOf("Full Website Development") }
    var projectDetails by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column {
                Text(
                    text = "Let's build something great together.",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Have a question or ready to kick off your project? Contact us through WhatsApp, direct phone call, or email.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Quick Direct Action Row
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // WhatsApp
                Button(
                    onClick = { ActionUtils.openWhatsApp(context) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF25D366)),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "💬 WhatsApp", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }

                // Call
                Button(
                    onClick = { ActionUtils.makeCall(context) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = WizhyOrange),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "📞 Call", color = WizhyCream, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }

                // Email
                Button(
                    onClick = { ActionUtils.sendEmail(context) },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "✉️ Email", color = MaterialTheme.colorScheme.onSurface, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }
        }

        // Inquiry Form Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "Send Direct Project Inquiry",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(14.dp))

                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Your Name") },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Phone / WhatsApp Number") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text("Email Address") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = projectDetails,
                        onValueChange = { projectDetails = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp),
                        label = { Text("Tell us about your project & requirements") },
                        shape = RoundedCornerShape(10.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            val inquiryMessage = buildString {
                                append("Hi Wizhy Web Studio!\n\n")
                                append("*Project Inquiry:*\n")
                                if (name.isNotBlank()) append("Name: $name\n")
                                if (phone.isNotBlank()) append("Phone: $phone\n")
                                if (email.isNotBlank()) append("Email: $email\n")
                                if (projectDetails.isNotBlank()) append("Details: $projectDetails\n")
                            }
                            ActionUtils.openWhatsApp(context, message = inquiryMessage)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = WizhyOrange),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(text = "Send Inquiry via WhatsApp ⚡", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Direct Studio Contact Info Card
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Wizhy Web Studio (WWS)",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "📞 Phone: +91-98707-06956", fontSize = 12.sp)
                    Text(text = "✉️ Email: techwizhy@gmail.com", fontSize = 12.sp)
                    Text(text = "🌐 Web: https://web.wizhy.in/", fontSize = 12.sp)
                    Text(text = "⏰ Hours: Mon–Sun 09:00–22:00 IST", fontSize = 12.sp)
                }
            }
        }
    }
}
