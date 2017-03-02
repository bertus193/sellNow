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
			await Navigation.PushAsync(new MainPage());
		}
	}
}
