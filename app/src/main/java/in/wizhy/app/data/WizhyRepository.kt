package in.wizhy.app.data

data class ServiceItem(
    val id: String,
    val number: String,
    val title: String,
    val description: String,
    val iconEmoji: String
)

data class PricingPlan(
    val id: String,
    val title: String,
    val badge: String? = null,
    val deliveryTime: String,
    val priceInr: String,
    val priceUsd: String,
    val originalInr: String,
    val originalUsd: String,
    val discount: String,
    val description: String,
    val perks: List<String>,
    val isFeatured: Boolean = false,
    val isFreeOffer: Boolean = false
)

data class MicroService(
    val title: String,
    val icon: String,
    val badge: String,
    val description: String,
    val priceInr: String,
    val priceUsd: String,
    val originalInr: String
)

data class ProcessStep(
    val stepNumber: String,
    val title: String,
    val duration: String,
    val description: String,
    val deliverables: List<String>
)

data class FaqItem(
    val question: String,
    val answer: String
)

data class WhyUsStat(
    val percent: Int,
    val icon: String,
    val title: String,
    val subtitle: String
)

object WizhyRepository {

    val services = listOf(
        ServiceItem("01", "01", "Website Development", "Custom-coded, blazing-fast, mobile-first websites built to convert visitors into loyal customers.", "💻"),
        ServiceItem("02", "02", "WordPress & CMS Solutions", "Custom Gutenberg themes, headless WordPress architecture, WooCommerce stores, and hardened security.", "⚙️"),
        ServiceItem("03", "03", "E-commerce Development", "High-converting online storefronts with seamless checkout flows and automated payment gateways.", "🛍️"),
        ServiceItem("04", "04", "SEO & Google Ranking", "On-page, technical SEO & Core Web Vitals optimization to rank your business at the top of Google searches.", "🔍"),
        ServiceItem("05", "05", "UI/UX & Web Design", "Human-centered interfaces, conversion-led layouts, and interactive design systems built for engagement.", "🎨"),
        ServiceItem("06", "06", "App & Portal Development", "Scalable web applications, customer portals, and cross-platform mobile apps tailored to your business.", "📱"),
        ServiceItem("07", "07", "Hosting & Maintenance", "Ultra-fast cloud servers, 99.9% uptime monitoring, daily backups, and ongoing security updates.", "🛡️"),
        ServiceItem("08", "08", "Branding & Identity", "Memorable brand identities, typography guidelines, vector assets, and cohesive visual language.", "✨"),
        ServiceItem("09", "09", "Conversion Optimization (CRO)", "Data-driven funnels, heatmaps, A/B landing page experiments, and analytics to maximize revenue.", "📈"),
        ServiceItem("10", "10", "Motion Graphics & Video", "Dynamic brand showreels, high-retention video edits, UI micro-animations, and viral social cuts.", "🎬"),
        ServiceItem("11", "11", "Logo Generation", "Iconic, versatile logos and vector marks engineered with distinct character to make your brand memorable.", "💎"),
        ServiceItem("12", "12", "Meta & Google Ads", "Laser-targeted Paid Search and Paid Social campaigns with optimized ad creatives and high ROAS bidding.", "🎯")
    )

    val pricingPlans = listOf(
        PricingPlan(
            id = "free",
            title = "First 10 Free Website",
            badge = "🎁 100% FREE OFFER",
            deliveryTime = "⚡ Only 4 Free Spots Left",
            priceInr = "0",
            priceUsd = "0",
            originalInr = "₹4,999",
            originalUsd = "$149",
            discount = "100% OFF",
            description = "For early businesses who want to experience our quality at zero development fee.",
            perks = listOf(
                "Full Custom Website built from scratch",
                "Phone & Computer Ready (100% Responsive)",
                "Google Ready basic SEO & fast speed",
                "Direct WhatsApp Button for client chats",
                "Condition: Honest review & testimonial after launch"
            ),
            isFreeOffer = true
        ),
        PricingPlan(
            id = "starter",
            title = "1-Page Starter Website",
            badge = "🔥 MOST POPULAR",
            deliveryTime = "⚡ 48-Hour Delivery",
            priceInr = "999",
            priceUsd = "29",
            originalInr = "₹4,999",
            originalUsd = "$79",
            discount = "80% OFF",
            description = "Ideal for small shops, freelancers, local services, and product launch pages.",
            perks = listOf(
                "1 Full Landing Page (Modern & conversion-focused)",
                "Instant WhatsApp Chat Button for direct buyer leads",
                "Mobile-First Speed (Loads in under 1 second)",
                "Contact & Lead Form with instant notification",
                "Google Search Ready meta tags & sitemap"
            ),
            isFeatured = true
        ),
        PricingPlan(
            id = "business",
            title = "Full Business Website",
            badge = "💼 RECOMMENDED",
            deliveryTime = "🚀 5-Day Delivery",
            priceInr = "4,999",
            priceUsd = "129",
            originalInr = "₹12,499",
            originalUsd = "$349",
            discount = "60% OFF",
            description = "For companies needing multiple pages (Home, About, Services, Contact, Blog).",
            perks = listOf(
                "Up to 5 Custom Pages (Home, About, Services, Contact)",
                "Easy Admin Panel to update text & images anytime",
                "Full Google Technical SEO + Schema structured data",
                "Lead Magnet or Booking integration (Calendly/WhatsApp)",
                "Free SSL Setup & hosting configuration support"
            )
        ),
        PricingPlan(
            id = "ecommerce",
            title = "Online Store / E-Commerce",
            badge = "🛍️ FULL STORE",
            deliveryTime = "🛍️ 7–10 Day Delivery",
            priceInr = "9,999",
            priceUsd = "249",
            originalInr = "₹24,999",
            originalUsd = "$599",
            discount = "60% OFF",
            description = "For brands ready to sell products online with automated checkout and payments.",
            perks = listOf(
                "Full Shopping Store (Cart, Catalog, Wishlist)",
                "Online UPI & Card Payments (Razorpay / Stripe)",
                "Automated Order Receipts & customer emails",
                "Google Analytics 4 & Meta Pixel tracking ready",
                "Inventory Management dashboard"
            )
        )
    )

    val microServices = listOf(
        MicroService("Logo Generation", "🎨", "24h Delivery", "3 distinct vector logo concepts with transparent background and favicon.", "99", "9", "₹999"),
        MicroService("Motion Video / Reel", "🎬", "Fast Turnaround", "Up to 30-sec high-retention reel with modern captions and sound design.", "499", "19", "₹1,999"),
        MicroService("Meta & Google Ads", "🎯", "ROAS Optimized", "Full ad campaign setup, pixel tracking, and 2 high-converting ad creatives.", "1,499", "49", "₹4,999")
    )

    val processSteps = listOf(
        ProcessStep(
            "01",
            "Discovery & Architecture",
            "Days 1–2",
            "We analyze your target market, competitors, and conversion pathways to craft an exact project blueprint.",
            listOf("Competitor Audit", "Sitemap & Wireframes", "Tech Stack Decision")
        ),
        ProcessStep(
            "02",
            "Design & Interactive Prototyping",
            "Days 3–4",
            "We craft pixel-perfect, mobile-first designs with custom color schemes and typography tailored to your brand.",
            listOf("Figma Prototypes", "Responsive Mobile Breakpoints", "Client Review & Feedback")
        ),
        ProcessStep(
            "03",
            "Clean Code Development",
            "Days 5–7",
            "Bespoke engineering with zero bloat. Ultra-clean markup, responsive CSS, and optimal JavaScript architecture.",
            listOf("Semantic HTML5/CSS3", "Core Web Vitals Optimization", "Database & API Integration")
        ),
        ProcessStep(
            "04",
            "Day-1 SEO & Speed Hardening",
            "Days 8–9",
            "Technical SEO audit, Schema markup injection, image compression, and server-side caching.",
            listOf("JSON-LD Rich Snippets", "Sub-0.8s Load Speed Tuning", "Sitemap & Search Console")
        ),
        ProcessStep(
            "05",
            "Launch & Ongoing Growth",
            "Day 10+",
            "Flawless production deployment with 99.9% uptime, SSL verification, and dedicated post-launch support.",
            listOf("Zero Downtime Go-Live", "Admin Training Session", "Continuous Growth Partnership")
        )
    )

    val faqs = listOf(
        FaqItem(
            "How long does a typical website project take?",
            "Most business websites take 2–4 weeks from kickoff to launch, depending on scope, number of pages, and how quickly feedback comes back. Starter websites are delivered in just 48 hours!"
        ),
        FaqItem(
            "Do you also handle SEO, or just design and development?",
            "SEO is built into every project from day one — not bolted on afterward. That includes technical SEO (site speed, structured data, mobile-friendliness) and on-page SEO (titles, meta descriptions, keyword alignment)."
        ),
        FaqItem(
            "What does a project typically cost?",
            "Starter websites begin at just ₹999 ($29). Full business multi-page websites are ₹4,999 ($129), and complete e-commerce stores are ₹9,999 ($249). We maintain 100% transparent pricing."
        ),
        FaqItem(
            "Will I be able to update the website myself after launch?",
            "Yes! We build on intuitive platforms with clean admin panels so you can update text, images, and products yourself without touching code."
        ),
        FaqItem(
            "Do you offer maintenance and support after the site goes live?",
            "Yes — we offer ongoing hosting, uptime monitoring, daily backups, security updates, and SEO retainers so your site keeps performing at its peak."
        ),
        FaqItem(
            "Can you redesign or improve my existing website?",
            "Absolutely! We regularly audit existing websites and offer redesign, speed optimization, and SEO revamps — often faster and more cost-effective than starting from scratch."
        )
    )

    val whyUsStats = listOf(
        WhyUsStat(92, "⚡", "Delivery Speed", "On-time milestones & agile launch sprints"),
        WhyUsStat(96, "🔍", "SEO Readiness", "Structured data, speed & keyword alignment"),
        WhyUsStat(98, "⭐", "Client Satisfaction", "Direct communication & dedicated support"),
        WhyUsStat(95, "💎", "Value for Price", "Agency-grade quality at transparent rates")
    )
}
