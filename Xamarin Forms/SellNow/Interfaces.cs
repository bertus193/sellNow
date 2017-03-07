using System;

namespace SellNow
{
	public class SellNowPageItem
	{
		public string Title { get; set; }

		public string IconSource { get; set; }

		public Type TargetType { get; set; }
	}

	public class Product
	{
		public string Title { get; set; }

		public Xamarin.Forms.ImageSource ImageSource { get; set; }

		public string TargetData { get; set; }
	}

	public class Category
	{
		public string Title { get; set; }

		public Xamarin.Forms.ImageSource ImageSource { get; set; }

		public Type TargetType { get; set; }
	}
}
