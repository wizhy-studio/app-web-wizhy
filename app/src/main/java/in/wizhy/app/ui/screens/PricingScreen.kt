package in.wizhy.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import in.wizhy.app.data.PricingPlan
import in.wizhy.app.data.WizhyRepository
import in.wizhy.app.ui.components.ActionUtils
import in.wizhy.app.ui.theme.AccentGold
import in.wizhy.app.ui.theme.AccentGreen
import in.wizhy.app.ui.theme.WizhyCream
import in.wizhy.app.ui.theme.WizhyOrange

@Composable
fun PricingScreen(
    selectedCurrency: String,
    onNavigateToContact: (String) -> Unit
) {
    val context = LocalContext.current
    val currSym = if (selectedCurrency == "INR") "₹" else "$"

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Section Header
        item {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(AccentGold.copy(alpha = 0.2f))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "🎁 STUDIO LAUNCH SPECIAL",
                            color = AccentGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Simple & Honest Pricing. No Hidden Fees.",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Pick the plan that fits your business. Clean code, fast delivery, and prices made for real growth.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // 4 Core Pricing Plans
        items(WizhyRepository.pricingPlans) { plan ->
            PricingCard(
                plan = plan,
                selectedCurrency = selectedCurrency,
                onSelect = {
                    val price = if (selectedCurrency == "INR") "₹${plan.priceInr}" else "$${plan.priceUsd}"
                    ActionUtils.openWhatsApp(
                        context = context,
                        message = "Hi Wizhy! I'd like to book the ${plan.title} ($price)."
                    )
                }
            )
        }

        // Quick Add-on Micro Services Section
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "⚡ Quick Creative Add-ons",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "Single-deliverable packages with rapid 24-48h turnaround.",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        items(WizhyRepository.microServices) { micro ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = micro.icon, fontSize = 28.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = micro.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "(${micro.badge})",
                                fontSize = 10.sp,
                                color = WizhyOrange,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Text(
                            text = micro.description,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            val price = if (selectedCurrency == "INR") "₹${micro.priceInr}" else "$${micro.priceUsd}"
                            Text(
                                text = price,
                                fontWeight = FontWeight.Black,
                                fontSize = 15.sp,
                                color = WizhyOrange
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = micro.originalInr,
                                fontSize = 11.sp,
                                textDecoration = TextDecoration.LineThrough,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    Button(
                        onClick = {
                            val price = if (selectedCurrency == "INR") "₹${micro.priceInr}" else "$${micro.priceUsd}"
                            ActionUtils.openWhatsApp(
                                context = context,
                                message = "Hi Wizhy! I want to book ${micro.title} ($price)."
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = WizhyOrange),
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(text = "Book", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun PricingCard(
    plan: PricingPlan,
    selectedCurrency: String,
    onSelect: () -> Unit
) {
    val currSym = if (selectedCurrency == "INR") "₹" else "$"
    val priceVal = if (selectedCurrency == "INR") plan.priceInr else plan.priceUsd
    val originalPrice = if (selectedCurrency == "INR") plan.originalInr else plan.originalUsd

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (plan.isFeatured) Modifier.border(2.dp, WizhyOrange, RoundedCornerShape(18.dp))
                else Modifier
            ),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (plan.isFreeOffer) MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            else MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            // Plan Badge
            plan.badge?.let { badgeText ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (plan.isFeatured) WizhyOrange else AccentGold.copy(alpha = 0.2f))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = badgeText,
                            color = if (plan.isFeatured) WizhyCream else AccentGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = plan.deliveryTime,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = WizhyOrange
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            Text(
                text = plan.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = plan.description,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Price Row
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = currSym,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = WizhyOrange,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = priceVal,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Black,
                    color = WizhyOrange
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.padding(bottom = 6.dp)) {
                    Text(
                        text = originalPrice,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.LineThrough,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = plan.discount,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = AccentGreen
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
            Spacer(modifier = Modifier.height(12.dp))

            // Perks List
            plan.perks.forEach { perk ->
                Row(
                    modifier = Modifier.padding(vertical = 3.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Text(text = "✓", color = AccentGreen, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = perk,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        lineHeight = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onSelect,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (plan.isFeatured) WizhyOrange else MaterialTheme.colorScheme.primaryContainer,
                    contentColor = if (plan.isFeatured) WizhyCream else MaterialTheme.colorScheme.onPrimaryContainer
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = if (plan.isFreeOffer) "Claim 1 of 10 Free Slots →" else "Get Started →",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
