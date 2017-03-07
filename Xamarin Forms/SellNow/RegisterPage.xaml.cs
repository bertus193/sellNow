using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class RegisterPage : ContentPage
	{
		public RegisterPage()
		{
			InitializeComponent();
		}
		async void OnRegisterButtonClicked(object sender, EventArgs e)
		{
<<<<<<< HEAD:Xamarin Forms/SellNow/RegisterPage.xaml.cs
			await Navigation.PushAsync(new MainPage(), false);
=======
			await Navigation.PushAsync(new LoginPage());
>>>>>>> 5a6499d7095b826935beb9ce6aa84ab49996e44c:Practica GCS/SellNow/SellNow/RegisterPage.xaml.cs
		}
	}
}
