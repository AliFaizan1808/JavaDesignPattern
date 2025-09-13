package pattern.structural;

public class Adaptor {
	
	public static void main(String[] args) {
		
		MakePhonePayPayment phonepayPayment = new PhonePayApp();
		phonepayPayment.doPaymentViaPhonePay("MyPhonePayUPIId@");
		
		
		//Adaptor
		MakePhonePayPayment phonepayPayments = new GooglePayAdaptor(new GooglePayApp());
		phonepayPayments.doPaymentViaPhonePay("MyPhonePayUPIId@");
		
		
	}

}


class GooglePayAdaptor implements MakePhonePayPayment{
	
	MakeGooglePayPayment gogglePayPayment;
	
	public GooglePayAdaptor(MakeGooglePayPayment gogglePayPayment){
		this.gogglePayPayment = gogglePayPayment;
	}
	

	@Override
	public void doPaymentViaPhonePay(String phonePayUpiID) {
		//logic to set env for the gogglePay
		gogglePayPayment.doPaymentViaGooglePay(phonePayUpiID + "googlrPayId");
		
	}
	
}



//Old interface
interface MakePhonePayPayment{
	
	void doPaymentViaPhonePay(String PhonePayUpiID);
}

interface MakeGooglePayPayment{
	
	void doPaymentViaGooglePay(String googlePayUpiID);
}


class PhonePayApp implements MakePhonePayPayment{

	@Override
	public void doPaymentViaPhonePay(String PhonePayUpiID) {
		// phone pay specific API
		System.out.println("Payment from phone pay");
	}
	
}

class GooglePayApp implements MakeGooglePayPayment{

	@Override
	public void doPaymentViaGooglePay(String googlePayUpiID) {
		// phone pay specific API
		System.out.println("Payment from google pay");
	}
	
}