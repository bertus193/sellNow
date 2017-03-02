using System;
using System.Collections.Generic;

using Xamarin.Forms;

namespace SellNow
{
	public partial class LoginPage : ContentPage
	{
		public LoginPage()
		{
			InitializeComponent();
		}

		async void OnRegisterButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new RegisterPage());
		}

		async void OnLoginButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new MainPage());
		}

		async void OnGoogleButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new MainPage());
		}

		async void OnFacebookButtonClicked(object sender, EventArgs e)
		{
			await Navigation.PushAsync(new MainPage());
		}
	}
}
